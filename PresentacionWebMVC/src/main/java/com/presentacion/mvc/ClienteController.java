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
import com.negocio.ventas.VEN_ClienteBL;


@Controller
public class ClienteController {
	@RequestMapping(value = "/RegistroCliente", method = RequestMethod.GET)
	public ModelAndView RegistroCliente(Locale locale, Model model) {
		try {
			return new ModelAndView("RegistroCliente/lista", 
							"listacliente", 
							VEN_ClienteBL.Instancia().ListarCliente());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return new ModelAndView("redirect:Error");
		}
	}
}
