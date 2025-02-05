package cursoSpringBoot.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cursoSpringBoot.model.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

//@Primary //Define un bean prioritario
@Service
@ConditionalOnProperty(name = "service.products", havingValue = "json")
//Servicio que Obtiene los products desde un json
public class ProductsServiceJSONImpl implements ProductService{

    @Override
    public List<Product> getProducts() {
        List<Product> products;

        //Proceso de des-serializacion
        try {
            products = new ObjectMapper().
                        readValue(this.getClass().getResourceAsStream("/products.json"),
                            new TypeReference<List<Product>>() {});
            return products;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
