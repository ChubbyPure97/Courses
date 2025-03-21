package cursoSpringBoot.controllers;

import cursoSpringBoot.configurations.ExternalizedConfigurations;
import cursoSpringBoot.model.Product;
import cursoSpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductRestController {
    /*No usamos esto debido al alto acoplamiento*/
    //Polimorfismo dinamico
    //Importante hacer esto, porque solo se modifica el servicio(comportamiento), pero no afecta al cliente.
    //ProductService productsService = new ProductsServiceImpl();

    //Inyeccion de dependencias por campo -> Bajo Acomplamiento
    @Autowired
    //@Qualifier("listResourceService") //Especificamos el bean que queremos inyectar
    @Lazy
    private ProductService productService;

    @Autowired
    private ExternalizedConfigurations externalizedConfigurations;

    @GetMapping
    public ResponseEntity<?> getProducts(){
        System.out.println(externalizedConfigurations.toString());

        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }
}
