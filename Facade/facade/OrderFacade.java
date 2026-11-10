package Facade.facade;

import Facade.model.OrderRequest;

/**
 * Facade Interface:
 * Provides a clean, unified high-level interface for order processing.
 */
public interface OrderFacade {
    boolean placeOrder(OrderRequest request);
}
