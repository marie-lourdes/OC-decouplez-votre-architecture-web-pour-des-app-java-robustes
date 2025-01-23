package com.airbusiness.airbusinessmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.airbusiness.airbusinessmvc.entities.Reservation;
import com.airbusiness.airbusinessmvc.repositories.ReservationRepository;

import jakarta.validation.Valid;


@Controller
public class ReservationController {
	/* en rendant le champs final et l injection dans le constuctor , aucune erreur mais l injection est sur le champ, le modificateur d acces Final cree une erreur demande l inititialisation */
	
	// @Autowired
	   private final ReservationRepository reservationRepository;

	/* l injection du constructor avec reservation repository et non directement sur le champ , permet de tester le controller en creant correctement l instance repository lor d un test unitaire
	 * d'autant plus si il plus instance et champs de classe a initialisé via le constructor , il est moins verbeux d injecter d irectement sur le constructor que sur plusieurs champs
	 * si la classe n a qu un seul constructor , l autowired n est necessaire
	 */
    
    @Autowired
    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
		
    }
/* ********** test autres parametre avec le model dans la requet get et une instance vide de reservation et @Modelattribute dans le requete POST dans la creation d une reservation ****** */
    @GetMapping("/new-trip")
    public String showNewTripForm(Model model) {
    	Reservation reservation = new Reservation();
    	model.addAttribute("reservation",reservation);
        return "add-reservation";
    }
    
    @PostMapping("/reservation/add")
    public String addReservation(@Valid @ModelAttribute Reservation reservation, BindingResult result) {
        if (result.hasErrors()) {
            return "add-reservation";
        }
  /* ************************************** */      
        reservationRepository.save(reservation);
    //    model.addAttribute("reservations", reservationRepository.findAll());
        return "reservations";
    }
    
    @GetMapping("/reservation/edit/{id}")
    public String showUpdateReservationForm(@PathVariable("id") long id, Model model) {
    	Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid reservation Id:" + id));
        model.addAttribute("reservation", reservation);
        return "update-reservation";
    }
    
    @PostMapping("/reservation/update/{id}")
    public String updateReservation(@PathVariable("id") long id, @Valid Reservation reservation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            reservation.setId(id);
            return "update-reservation";
        }
        
        reservationRepository.save(reservation);
        model.addAttribute("reservations", reservationRepository.findAll());
        return "reservations";
    }
    
    @GetMapping("/reservation/delete/{id}")
    public String deleteReservation(@PathVariable("id") long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid reservation Id:" + id));
        reservationRepository.delete(reservation);
        /* **mieux vaut rediriger avec le lien GET /reservation , que recharger les données (addAttribute) du model reservations avec la donnée supprimé***/
       // model.addAttribute("reservations", reservationRepository.findAll());
        return "redirect:/reservations";
    }
    
 	@RequestMapping("/reservations")
 	public String reservationsForm(Model model) {
 		model.addAttribute("reservations", reservationRepository.findAll());
 		return "reservations";
 	}
}
