package credit_process;

import com.credit.app.system.creditappsystem.document.Users;
import com.credit.app.system.creditappsystem.repository.UserRepository;
import com.credit.app.system.creditappsystem.resource.UsersResource;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

public class CreditProcess {

	private final static String ACCOOUNT_SID ="AC7efdd0d93deb156b654f7cfa119aa699";
	private final static String AUTH_TOKEN ="9bbb67de7fe5f227538d9054d8e15aea";
	//aycem burda
	public static int myProcess(Users user) {
		
		UserRepository userRe = UsersResource.userRepository;
		int credit_limit_mult=4;
		int result=0;
		
		
				if((userRe.findById(user.getId())).get().getCredit_score() < 500) 
				{
						
						userRe.save(user);
						System.out.println("kredi onaylanmadi");
						
						Twilio.init(ACCOOUNT_SID, AUTH_TOKEN);
						Message.creator(new PhoneNumber(user.getPhonenum()),new PhoneNumber("+17125877368"),"Krediniz onaylanmadı").create();
						
				}
				else if(500 < (userRe.findById(user.getId())).get().getCredit_score()
						&& (userRe.findById(user.getId())).get().getCredit_score() < 1000) 
				{
					userRe.save(user);
					if((userRe.findById(user.getId())).get().getSalary() <5000) {
						
						  result=1;		
						  System.out.println("onaylandı");								  
						 
					      user.setLimit(10000);//databasede 10000 tl limit ver 
					      userRe.save(user);
					      
					      Twilio.init(ACCOOUNT_SID, AUTH_TOKEN);
						  Message.creator(new PhoneNumber(user.getPhonenum()),new PhoneNumber("+17125877368"),"Krediniz onaylandı, 10000 TL limitiniz vardır").create();
						
					}
						  
				}
				else if(1000== (userRe.findById(user.getId())).get().getCredit_score() 
						|| 1000 < (userRe.findById(user.getId())).get().getCredit_score()) 
				{
						result=1;
						System.out.println("onaylandı2");
						userRe.save(user);
						int limit =((userRe.findById(user.getId())).get().getSalary() )* credit_limit_mult;
						user.setLimit(limit);
						userRe.save(user);
						
						Twilio.init(ACCOOUNT_SID, AUTH_TOKEN);
						String mes= "Krediniz onaylandı,"+ limit+" TL limitiniz vardır.";
						Message.creator(new PhoneNumber(user.getPhonenum()),new PhoneNumber("+17125877368"),mes).create();
							
				}
				
				return result;
				
		}
	
}
