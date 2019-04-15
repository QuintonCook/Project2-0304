package com.example.email;

import java.io.IOException;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

public class EmailHandler {
	// Replace sender@example.com with your "From" address.
		  // This address must be verified with Amazon SES.
		  static final String FROM = "senderTestemail69@gmail.com";

		  // Replace recipient@example.com with a "To" address. If your account
		  // is still in the sandbox, this address must be verified.
		  static String TO = "projTestemail69@gmail.com";

		  // The configuration set to use for this email. If you do not want to use a
		  // configuration set, comment the following variable and the 
		  // .withConfigurationSetName(CONFIGSET); argument below.
		  //static final String CONFIGSET = "ConfigSet";

		  // The subject line for the email.
		  static final String SUBJECT = "See if this shit workin bruh";
		  
		  // The HTML body for the email.
		  static final String HTMLBODY = "<h1>ResetBoiiiii</h1>"
		      + "<p>Click to reset password <a href='http://localhost:4200/resetpassword'>"
		      + "Reset</a>";

		  // The email body for recipients with non-HTML email clients.
		  static final String TEXTBODY = "Mac is for fags "
		      + "6 million wasn't enough";
		  public static void setReciever(String rec){TO = rec; }
		  
		  public static void sendEmail() throws IOException {

		    try {
		      AmazonSimpleEmailService client = 
		          AmazonSimpleEmailServiceClientBuilder.standard()
		          // Replace US_WEST_2 with the AWS Region you're using for
		          // Amazon SES.
		            .withRegion(Regions.US_EAST_1).build();
		      SendEmailRequest request = new SendEmailRequest()
		          .withDestination(
		              new Destination().withToAddresses(TO))
		          .withMessage(new Message()
		              .withBody(new Body()
		                  .withHtml(new Content()
		                      .withCharset("UTF-8").withData(HTMLBODY))
		                  .withText(new Content()
		                      .withCharset("UTF-8").withData(TEXTBODY)))
		              .withSubject(new Content()
		                  .withCharset("UTF-8").withData(SUBJECT)))
		          .withSource(FROM);
		          // Comment or remove the next line if you are not using a
		          // configuration set
		      client.sendEmail(request);
		      System.out.println("Oh shit Email sent!");
		    } catch (Exception ex) {
		      System.out.println(" Fuck the email was not sent. Error message: " 
		          + ex.getMessage());
		    }
		  }
}
