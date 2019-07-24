package com.ies.curso.spring.tema06.ejemplo02.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ies.curso.spring.Application;
import com.ies.curso.spring.tema05.ejemplo04.dto.RegistroContable;
import com.ies.curso.spring.tema05.ejemplo04.services.ContabilidadService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)			
public class ContabilidadControllerTest {

	MockMvc mockMvc;
    
	@Mock 
    protected ContabilidadService contabilidadService;
    
    @InjectMocks 
    protected ContabilidadController contabilidadController;
    
    @Before
    public void preTest() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
          .standaloneSetup(contabilidadController)
          .build();
    }
    
    @Test
    public void desplegarRegistrosTest() throws Exception {
    	when(contabilidadService
    		.obtenerRegistrosPeriodo(LocalDate.now(), LocalDate.now()))
    		.thenReturn(obtenerRegistros());
    	
    	mockMvc
    		.perform(get("/restapi/"))
    		 .andDo(print())
    		 .andExpect(status().isOk())
    		 .andExpect(content().json("[\n" + 
    		 		"    {\n" + 
    		 		"        \"cuenta\": null,\n" + 
    		 		"        \"cargo\": 5000.0,\n" + 
    		 		"        \"abono\": 10000.0\n" + 
    		 		"    },\n" + 
    		 		"    {\n" + 
    		 		"        \"cuenta\": null,\n" + 
    		 		"        \"cargo\": 10000.0,\n" + 
    		 		"        \"abono\": 20000.0\n" + 
    		 		"    }]"));
    	
    }
 
    
    
    protected List<RegistroContable> obtenerRegistros(){
		List<RegistroContable> registros = new ArrayList<>();
		for(int i=1;i<=2;i++) {
			RegistroContable r = new RegistroContable();
			r.setAbono((double)i*10000);
			r.setCargo((double)i*5000);
			registros.add(r);
		}
		return registros;
	}
}
