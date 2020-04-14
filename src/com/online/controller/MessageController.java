package com.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.domain.MessageDomain;
import com.online.utils.MessageUtils;

/**
 * 消息控制器
 * 
 * @author xxd
 *
 */
@Controller
@RequestMapping("/message")
public class MessageController {
	@Autowired
	MessageUtils utils;

	public MessageController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping
	@ResponseBody
	public boolean Send(MessageDomain domain) {
		System.out.println(domain);
		return utils.send(domain);
	}

	@GetMapping
	@ResponseBody
	public List<MessageDomain> get() {
		return utils.getMessage();
	}

}
