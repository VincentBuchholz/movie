/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.MovieDTO;
import entities.Movie;

import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        MovieFacade fe = MovieFacade.getFacadeExample(emf);
        fe.create(new MovieDTO(new Movie(2015,"Viktors hjemmevideo",new String[]{"Viktor","Mor"})));
        fe.create(new MovieDTO(new Movie(2017,"Vincents hjemmevideo",new String[]{"Vincent","Far"})));
        fe.create(new MovieDTO(new Movie(2021,"Help im stuck",new String[]{"Philippe","Stepmom"})));

    }
    
    public static void main(String[] args) {
        populate();
    }
}
