package com.presentacion.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.entidades.seguridad.SEG_UsuarioEL;
import com.negocio.seguridad.SEG_UsuarioBL;


@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		return new ModelAndView("home", "command", new SEG_UsuarioEL());
	}
	
	@RequestMapping(value = "/VerificarAcceso", method = RequestMethod.POST)
	public String VerificarAcceso(@ModelAttribute("SpringWeb")SEG_UsuarioEL u, 
								ModelMap model){
		try {
			String _Usuario = u.getLogin();
			String _Pass = u.getPassword();
			SEG_UsuarioBL.Instancia().VerificarAcceso(_Usuario, _Pass);
			return "frmPrincipal";
		} catch (ArithmeticException e) {
			model.addAttribute("error", e.getMessage());
			model.addAttribute("command", new SEG_UsuarioEL());
			return "home";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "Error";
		}
	}
	
}
