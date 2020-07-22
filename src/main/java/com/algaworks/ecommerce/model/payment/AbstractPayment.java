package com.algaworks.ecommerce.model.payment;

import com.algaworks.ecommerce.model.commons.EntityBaseCommons;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public abstract class AbstractPayment extends EntityBaseCommons implements Serializable {
    private static final long serialVersionUID = 8422804185263106977L;



}
