/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @author Ashwin Antony
 */
@FacesValidator("fieldValidation")
public class FieldValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String fieldValue = value.toString();

        // Check if the input field is empty
        if (fieldValue.equals("")) {
            throw new ValidatorException(new FacesMessage("Empty field detected! Please enter value. Thank you!"));
        }
    }
}
