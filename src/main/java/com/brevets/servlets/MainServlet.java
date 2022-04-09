package com.brevets.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ismo.brevets.dao.DaoInvention;
import com.ismo.brevets.metier.IMetier;
import com.ismo.brevets.metier.MetierBrevet;
import com.ismo.brevets.metier.MetierDomaine;
import com.ismo.brevets.metier.MetierEntreprise;
import com.ismo.brevets.metier.MetierInventeur;
import com.ismo.brevets.metier.MetierInvention;
import com.ismo.brevets.models.Brevet;
import com.ismo.brevets.models.Domaine;
import com.ismo.brevets.models.Entreprise;
import com.ismo.brevets.models.Inventeur;
import com.ismo.brevets.models.Invention;


@WebServlet("/")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		switch (request.getServletPath()) {
		
			// READ ALL
			case "/domaine":{
				IMetier<Domaine> metierDomaine = new MetierDomaine();
				request.setAttribute("title", "Domaine");
				request.setAttribute("list", metierDomaine.getAll());
				request.setAttribute("page", "../views/domaine.jsp");
			} break;
			case "/entreprise":{
				IMetier<Entreprise> metierEntreprise = new MetierEntreprise();
				request.setAttribute("title", "Entreprise");
				request.setAttribute("list", metierEntreprise.getAll());
				request.setAttribute("page", "../views/entreprise.jsp");
			} break;
			case "/inventeur":{
				IMetier<Inventeur> metierInventeur = new MetierInventeur();
				request.setAttribute("title", "Inventeur");
				request.setAttribute("list", metierInventeur.getAll());
				request.setAttribute("page", "../views/inventeur.jsp");
			} break;
			case "/invention":{
				IMetier<Invention> metierInvention = new MetierInvention();
				request.setAttribute("title", "Invention");
				request.setAttribute("list", metierInvention.getAll());
				request.setAttribute("page", "../views/invention.jsp");
			} break;
			case "/brevet":{
				IMetier<Brevet> metierBrevet = new MetierBrevet();
				request.setAttribute("title", "Brevet");
				request.setAttribute("list", metierBrevet.getAll());
				request.setAttribute("page", "../views/brevet.jsp");
			} break;
			
			
			case "/add-domaine":{
				IMetier<Domaine> metierDomaine = new MetierDomaine();
				request.setAttribute("title", "Domaine");
				request.setAttribute("list", metierDomaine.getAll());
				request.setAttribute("page", "../views/domaine.jsp");
			} break;
			case "/edit-domaine":{
				IMetier<Domaine> metierDomaine = new MetierDomaine();
				request.setAttribute("title", "Domaine");
				request.setAttribute("list", metierDomaine.getAll());
				request.setAttribute("page", "../views/domaine.jsp");
			} break;
			
			// DELETE
			case "/delete-domaine":{
				Domaine domaine = new Domaine();
				domaine.setNum(Integer.parseInt(request.getParameter("num")));
				IMetier<Domaine> metierDomaine = new MetierDomaine();
				if(metierDomaine.delete(domaine))
					request.setAttribute("message", "Domaine "+domaine.getNum()+" deleted successfuly");
				else
					request.setAttribute("messageErr", "Domaine "+domaine.getNum()+" wasn't deleted !! Check if there is any realtion with it before delete it!!");
				request.setAttribute("list", metierDomaine.getAll());
				request.setAttribute("page", "../views/domaine.jsp");
			} break;
			
			case "/delete-entreprise":{
				Entreprise entreprise = new Entreprise();
				entreprise.setNum(Integer.parseInt(request.getParameter("num")));
				IMetier<Entreprise> metierEntreprise = new MetierEntreprise();
				if(metierEntreprise.delete(entreprise))
					request.setAttribute("message", "Entreprise "+entreprise.getNum()+" deleted successfuly");
				else
					request.setAttribute("messageErr", "Entreprise "+entreprise.getNum()+" wasn't deleted !! Check if there is any realtion with it before delete it!!");
				request.setAttribute("list", metierEntreprise.getAll());
				request.setAttribute("page", "../views/entreprise.jsp");
			} break;
			
			case "/delete-inventeur":{
				Inventeur inventeur = new Inventeur();
				inventeur.setNum(Integer.parseInt(request.getParameter("num")));
				IMetier<Inventeur> metierInventeur = new MetierInventeur();
				if(metierInventeur.delete(inventeur))
					request.setAttribute("message", "Inventeur "+inventeur.getNum()+" deleted successfuly");
				else
					request.setAttribute("messageErr", "Inventeur "+inventeur.getNum()+" wasn't deleted !! Check if there is any realtion with it before delete it!!");
				request.setAttribute("list", metierInventeur.getAll());
				request.setAttribute("page", "../views/inventeur.jsp");
			} break;
			
			case "/delete-invention":{
				Invention invention = new Invention();
				invention.setNum(Integer.parseInt(request.getParameter("num")));
				IMetier<Invention> metierInvention = new MetierInvention();
				if(metierInvention.delete(invention))
					request.setAttribute("message", "Invention "+invention.getNum()+" deleted successfuly");
				else
					request.setAttribute("messageErr", "Invention "+invention.getNum()+" wasn't deleted !! Check if there is any realtion with it before delete it!!");
				request.setAttribute("list", metierInvention.getAll());
				request.setAttribute("page", "../views/invention.jsp");
			} break;
			
			case "/delete-brevet":{
				Brevet brevet = new Brevet();
				brevet.setNum(Integer.parseInt(request.getParameter("num")));
				IMetier<Brevet> metierBrevet = new MetierBrevet();
				if(metierBrevet.delete(brevet))
					request.setAttribute("message", "Brevet "+brevet.getNum()+" deleted successfuly");
				else
					request.setAttribute("messageErr", "Brevet "+brevet.getNum()+" wasn't deleted !! Check if there is any realtion with it before delete it!!");
				request.setAttribute("message", "Domaine "+brevet.getNum()+" deleted successfuly");
				request.setAttribute("list", metierBrevet.getAll());
				request.setAttribute("page", "../views/brevet.jsp");
			} break;
			
			
			default:{
				DaoInvention daoInvention = new DaoInvention();
				request.setAttribute("inventionByDomaine", daoInvention.getAllByDomaine());
				request.setAttribute("inventionByEntreprise", daoInvention.getAllByEntreprise());
				request.setAttribute("title", "Home");
				request.setAttribute("page", "../views/home.jsp");
			} break;
		}
		
		request.setAttribute("servletPath", request.getServletPath());
		request.getRequestDispatcher("views/template.jsp").forward(request, response);
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
