package com.shabushabu.javashop.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import io.opentracing.Scope;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;
import com.shabushabu.javashop.shop.services.ProductService;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

 //  @RequestMapping("/") 
   @RequestMapping(value="/", method = RequestMethod.GET)
   public String usingRequestParam(Model model, @RequestParam(value="name", required=true) String thename, @RequestParam(value="color", required=true) String thecolor) {
     
     final Tracer s_tracer = GlobalTracer.get();
     final Span span = s_tracer.buildSpan("usingRequestParam").start();
     try (Scope scope = s_tracer.scopeManager().activate(span)) {
         span.setTag("name",thename);
         span.setTag("favcolor", thecolor);
         model.addAttribute("user", new User())
         model.addAttribute("products", productService.getProducts());
		   	     
         } finally {
           span.finish();
	 }		       
     return "index";
   }
   
   
    @PostMapping("/adduser")
    public String addUser(@Valid User user, Model model) {
    	 final Tracer s_tracer = GlobalTracer.get();
         final Span span = s_tracer.buildSpan("adduser").start();
         try (Scope scope = s_tracer.scopeManager().activate(span)) {
             span.setTag("name", user.getName());
             span.setTag("favcolor", user.getColor());
             model.addAttribute("products", productService.getProducts()); 	     
         } finally {
               span.finish();
         }		       
         return "index";
    }
 /*  
   @RequestMapping(value="/adduser", method = RequestMethod.POST)
   public String setUser(Model model,  @RequestParam String name, @RequestParam String color) {

       final Tracer s_tracer = GlobalTracer.get();
       final Span span = s_tracer.buildSpan("adduser").start();
       try (Scope scope = s_tracer.scopeManager().activate(span)) {
           span.setTag("name", name);
           span.setTag("favcolor", color);
           model.addAttribute("products", productService.getProducts());
  		   	     
           } finally {
             span.finish();
           }		       
       return "index";
   }
*/
   
  /* 
   @RequestMapping("/")
   public String index(Model model) {
	model.addAttribute("products", productService.getProducts());
        return "index";
    }
  */
/*    
    @GetMapping("/register")
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
	return "register_form";
    }
	
    @PostMapping("/register")
        public String submitForm(@ModelAttribute("user") User user) {
		//System.out.println(user);
	    return "redirect:register/success";
    }

    @RequestMapping("/success")
    public String index(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "product_index";
    }
 */
  /*  @GetMapping("/greeting")
    public String greetingForm(Model model) {
      model.addAttribute("greeting", new Greeting());
    return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
      model.addAttribute("greeting", greeting);
      return "result";
   }
   */
	
}
