/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Basic Crud Services>*/
package ca.gbc.comp3095.comp3095rockstars.services;

import java.util.Set;

public interface CrudService<T, ID>{

    Set<T> findAll();

    T findById(ID id);

    void delete(T object);

    void deleteById(ID id);
}
