package com.ninatompkin.beltreviewer.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.ninatompkin.beltreviewer.models.Event;
import com.ninatompkin.beltreviewer.models.Message;
import com.ninatompkin.beltreviewer.models.User;
import com.ninatompkin.beltreviewer.repositories.EventRepository;
import com.ninatompkin.beltreviewer.repositories.MessageRepository;
import com.ninatompkin.beltreviewer.repositories.UserRepository;

@Service
public class ApiService {
	private final UserRepository userRepo;
	private final EventRepository eventRepo;
	private final MessageRepository messageRepo;
	
	public ApiService(UserRepository userRepo, EventRepository eventRepo, MessageRepository messageRepo) {
		this.userRepo = userRepo;
		this.eventRepo = eventRepo;
		this.messageRepo = messageRepo;
	}

//////////////Login and Registration Related Methods//////////////////////
	// register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepo.save(user);
    }

    // find user by email
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = userRepo.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepo.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
        	// if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
  
  /////////////Event-Related Services/////////////////////////
   
  //Save an event to the database
  public Event createOrUpdateEvent(Event event) {
	  return eventRepo.save(event);
  }
  
  //Return this users' state with an id
  public String thisUsersState(Long user_id) {
	  User thisUser = userRepo.findById(user_id).orElse(null); 
	  return thisUsersState(thisUser);
  }
  
  //Return this users' state with a user object
  public String thisUsersState(User user) {
	  return user.getState();
  }
  
  //Return all Events from User's state
  public List<Event> eventsInYourState(Long user_id){
	  String myState = thisUsersState(user_id);
	  return eventRepo.findByState(myState);
  }
  
  //Return all Events Not from Users's state
  public List<Event> eventsNotInYourState(Long user_id){
	  String myState = thisUsersState(user_id);
	  return eventRepo.findByStateIsNot(myState);
  }
 
  //Find one Event by Id
  public Event findThisEvent(Long eventId) {
	  Event thisEvent = eventRepo.findById(eventId).orElse(null);
	  return thisEvent;
  }
  
  //Delete one Event By Id
  public void deleteThisEvent(Long eventId) {
	  Event thisEvent = findThisEvent(eventId);
	  eventRepo.delete(thisEvent);
  }
  
  //Have a member join an event
  public void joinThisEvent(Long eventId, Long userId) {
	  Event thisEvent = findThisEvent(eventId);
	  User thisUser = userRepo.findById(userId).orElse(null);
	  thisEvent.addMember(thisUser);  
	  eventRepo.save(thisEvent);
  }
  
  //Have someone remove themselves from an event
  public void stopGoingToThisEvent(Long eventId, Long userId) {
	  Event thisEvent = findThisEvent(eventId);
	  User thisUser = userRepo.findById(userId).orElse(null);
	  thisEvent.getMembers().remove(thisUser);
	  eventRepo.save(thisEvent);
  }
  
  ///////////////MESSAGE-RELATED SERVICES///////////////////
  public Message createMessage(String content, Long authorId, Long eventId) {
	  Event thisEvent = eventRepo.findById(eventId).orElse(null);
	  User author = userRepo.findById(authorId).orElse(null);
	  Message message = new Message(content, author, thisEvent);
	  return messageRepo.save(message);
  }
  
  //Return all Messages Attached to One Event
  public List<Message> findMessagesForThisEvent(Long eventId){
	  Event thisEvent = eventRepo.findById(eventId).orElse(null);
	  return thisEvent.getMessages();
  }

}
