package cursoSpringBoot.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app") //Sin el prefix, no funcionaria
public class ExternalizedConfigurations {

    //Atributos del archivo de configuracion
    private String name;
    private String version;
    private String autor;
    private String language;
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString(){
        return "Externalized Configurations: " + "\n" +
                "nombre=" + this.getName() + "\n" +
                "pais=" + this.getCountry() + "\n" +
                "autor=" + this.getAutor() + "\n" +
                "idioma=" + this.getLanguage() + "\n";
    }
}
