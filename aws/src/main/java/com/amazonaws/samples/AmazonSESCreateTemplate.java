/**
 * 
 */
package com.amazonaws.samples;

import java.util.List;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.CreateTemplateRequest;
import com.amazonaws.services.simpleemail.model.GetTemplateRequest;
import com.amazonaws.services.simpleemail.model.GetTemplateResult;
import com.amazonaws.services.simpleemail.model.ListTemplatesRequest;
import com.amazonaws.services.simpleemail.model.ListTemplatesResult;
import com.amazonaws.services.simpleemail.model.Template;
import com.amazonaws.services.simpleemail.model.TemplateMetadata;

/**
 * @author SVunnam
 *
 */
public class AmazonSESCreateTemplate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		 try {
		      AmazonSimpleEmailService client = 
		          AmazonSimpleEmailServiceClientBuilder.standard()
		          // Replace US_WEST_2 with the AWS Region you're using for
		          // Amazon SES.
		            .withRegion(Regions.US_WEST_2).build();
		      CreateTemplateRequest createTemplateRequest = new CreateTemplateRequest();
		      Template template = new Template();
		      template.setHtmlPart("<html><body>SES JDK Template HTML</body></html>");
		      template.setSubjectPart("SES JDK Template Subject");
		      template.setTemplateName("SES_JDK_Template");
		      template.setTextPart("Hello How are you");
			createTemplateRequest.setTemplate(template );
			GetTemplateRequest getTemplateRequest = new GetTemplateRequest();
			getTemplateRequest.setTemplateName("SES_JDK_Template");
			//client.createTemplate(createTemplateRequest );
			GetTemplateResult getTemplateResult = client.getTemplate(getTemplateRequest );
			System.out.println(getTemplateResult.getTemplate());
			ListTemplatesRequest listTemplatesRequest = new ListTemplatesRequest();
			listTemplatesRequest.setMaxItems(100);
			ListTemplatesResult listTemplatesResult = client.listTemplates(listTemplatesRequest );
			List<TemplateMetadata> templateMetadatas = listTemplatesResult.getTemplatesMetadata();
			for(TemplateMetadata metadata:templateMetadatas) {
				System.out.println(metadata);
			}
		 }catch (Exception e) {
			e.printStackTrace();
		}

	}

}
