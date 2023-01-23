package com.example.proiect_final.controller;

import com.example.proiect_final.model.ReturnOrder;
import com.example.proiect_final.model.Shop;
import com.example.proiect_final.service.ReturnOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("proiect")
public class ReturnOrderController {

    private final ReturnOrderService returnOrderService;

    public ReturnOrderController( ReturnOrderService returnOrderService ){
        this.returnOrderService = returnOrderService;
    }

    @PostMapping("returnOrder/newCompletely")
    public ResponseEntity<ReturnOrder> saveReturnOrderCompletely(@RequestBody ReturnOrder returnOrder,
                                                                 @RequestParam Integer orderId) {
        return ResponseEntity.ok().body(returnOrderService.saveNewReturnOrderCompletely(returnOrder, orderId));
    }
}
