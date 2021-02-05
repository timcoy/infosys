package com.infosys.anz.restapp.control;

/**
 * This class is used to filter specific properties and reduce payload sizes as required.
 * 
 * @author Tim Coy tim.coy@gmail.com
 *
 */
public class PayloadFilter {

    /**
     * 
     * A base view for properties that should always be included
     *
     */
    public interface BaseView {
    }

    /**
     *
     * A filtered view of Accounts without transactions
     */
    public interface Accounts extends BaseView {
    }

    /**
     * 
     * A filtered view of transactions
     *
     */
    public interface Transactions extends BaseView {
    }
}
