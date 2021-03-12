/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Base Entity class that sets ID property along with setter and getter>*/

package ca.gbc.comp3095.comp3095rockstars.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


public class BaseEntity implements Serializable {


    private long id;

    public long getId(){return id;}

    public void setId(Long id){this.id = id;}
}
