package fr.ynov.dap.googleController;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ynov.dap.googleService.GMailService;

@Controller
public class GmailController {
	@Autowired
	GMailService gmailservice;

	@RequestMapping("/UnreadMail/google/{accountName}")
	public String getUnReadGoogleEmails(@PathVariable("accountName") String accountName, Model model)
			throws IOException, GeneralSecurityException {

        //TODO bes by Djer |MVC| Ne met pas de "text" dans ton controller, c'est le rôle de la vue (ou du client).
		model.addAttribute("add", "Nb Unread Mail for :" + accountName);
		 //TODO bes by Djer |Thymleaf| Le nom "onSuccess" me parait étrange, il s'agit plutot du "nbContact"
		model.addAttribute("onSuccess", gmailservice.getListEmails(accountName).size());
		return "Info";

	}
}
