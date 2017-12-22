package com.immediateactiongroup.issues.controller;

import com.immediateactiongroup.issues.IssuesApplicationTests;
import com.immediateactiongroup.issues.dto.validate.UserLoginDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Author xueshan.wei
 * @Date 2017/12/17 下午12:29
 */
public class AuthControllerTest extends IssuesApplicationTests {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testGetAuthToken() throws Exception{
        UserLoginDTO userLoginDTO = UserLoginDTO.builder()
                .username("admin")
                .password("123455")
                .build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/session")
                    .param("username", userLoginDTO.getUsername())
                    .param("password", userLoginDTO.getPassword())
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
