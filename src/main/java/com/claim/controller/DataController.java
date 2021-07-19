package com.claim.controller;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import com.claim.entity.DataTransferObject;


@Controller
public class DataController {

	@MessageMapping("/data")
	@SendTo("/topic/data")
	public DataTransferObject getData(DataTransferObject data) {

		return new DataTransferObject(data.getName(), data.getMessage());
		
	}	

}
	
	

