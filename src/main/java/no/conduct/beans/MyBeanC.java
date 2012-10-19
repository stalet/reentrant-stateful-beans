package no.conduct.beans;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: stalet
 * Date: 10/19/12
 * Time: 8:10 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateful
@SessionScoped
@Named(value = "beanC")
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class MyBeanC implements Serializable {

    private int counter;

    @Inject
    private MyBeanA beanA;
    @Inject
    private MyBeanB beanB;

    @PostConstruct
    public void init()
    {
        loadSomeData();
        beanA.loadSomeData();
    }

    public void loadSomeData()
    {
        counter += 100;
    }

    public String getCounter()
    {
        return "bean C " + counter++ + " " + beanA.getCounterValue() + beanB.getCounterValue();
    }


}
