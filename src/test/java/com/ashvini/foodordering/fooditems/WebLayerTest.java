package com.ashvini.foodordering.fooditems;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ashvini.foodordering.fooditems.controllers.FoodItemsController;

@RunWith(SpringRunner.class)
@WebMvcTest(value=FoodItemsController.class)
public class WebLayerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnFoodItemsList() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fooditem/name/Modak")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		
		String expected = "{\r\n"
				+ "        \"foodItemNo\": 102,\r\n"
				+ "        \"foodItemName\": \"Modak\",\r\n"
				+ "        \"foodItemVendor\": {\r\n"
				+ "            \"vendorId\": 4,\r\n"
				+ "            \"vendorName\": \"Samsung\"\r\n"
				+ "        },\r\n"
				+ "        \"foodItemPrice\": 50";
		
		JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
				
	}
}
