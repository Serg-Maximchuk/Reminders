package com.serhii.reminder;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	private List<String> list;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public void add(@RequestParam String text) {
		list.add(text);
		System.out.println("Adding item: " + text);
		System.out.println(list);
		Writer.writeToFile(list);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(@RequestParam String text) {
		list.remove(text);
		System.out.println("Deleting item: " + text);
		System.out.println(list);
		Writer.writeToFile(list);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void change(@RequestParam int id, @RequestParam String text) {
		list.set(id, text);
		System.out.println("Updating item: " + text);
		System.out.println(list);
		Writer.writeToFile(list);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		list = new LinkedList<>();
		return "home";
	}
}
