import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;


import javax.swing.*;

public class Teste1 {

    private WebDriver driver;
    private String url;

    //Executado antes de cada método de teste
    @BeforeMethod
    public void before(){
        String caminhoDriver = "C:\\Users\\polym\\Documents\\chromedriver.exe";
        url = System.getProperty("user.dir")+"\\src\\paginas\\componentes.html";
        System.setProperty("webdriver.chrome.driver", caminhoDriver);

        driver = new ChromeDriver();
    }
    @Test
    public void teste1() {
        //Abrindo a página
        driver.get(url);
        //Inserir nome
        WebElement nome = driver.findElement(By.id("elementosForm:nome"));
        nome.sendKeys("Nanda/Eduardo");
        //Inserir sobrenome
        WebElement sobrenome = driver.findElement(By.id("elementosForm:sobrenome"));
        sobrenome.sendKeys("Dantas/Rodrigues");
        //Selecionar Sexo (vamos colocar feminino para testar)
        WebElement sexoF = driver.findElement(By.id("elementosForm:sexo:1")).click();
        //Selecionar Carne
        WebElement carne = driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        //Selecionar Frango
        WebElement frango = driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
        //Selecionar Doutorado
        Select listaEscolaridade = new Select(driver.findElement(By.id("elementosForm:escolaridade")));
        listaEscolaridade.selectByVisibleText("Doutorado");
        //Selecionar Natação
        Select listaEsporte = new Select(driver.findElement(By.id("elementosForm:esportes")));
        listaEsporte.selectByVisibleText("Natacao");
        //Informar Sugestões
        WebElement sugestao = driver.findElement(By.name("elementosForm:sugestoes"));
        sugestao.sendKeys("Nenhuma sugestao ate o momento.");
        //Marcar checkbox da Linha maria da tabela
        Select checkboxMaria = new Select(driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[8]/td[2]/table/tbody/tr[2]/td[4]")));
        checkboxMaria.selectByIndex(0);
        //Marcar radio da linha Usuário A da tabela
        Input radioA = new Input(driver.findElement(By.xpath("//*[@id="elementosForm:tableUsuarios"]/tbody/tr[3]/td[5]/table/tbody/tr/td/input")));
        radioA.click();
        //Preencher input da linha Usuário B da tabela
        Input linhaB = new Input(driver.findElement(By.xpath("//*[@id="elementosForm:tableUsuarios"]/tbody/tr[5]/td[6]/input")));
        linhaB.sendKeys("InputB");

        //Clicar em cadastrar
        WebElement cadastrar = driver.findElement(By.id("elementosForm:cadastrar"));
        cadastrar.click();
        //Verificar se a mensagem "Cadastrado!" foi exibido
        String resultado = driver.findElement(By.xpath("//*[@id="resultado"]/span")).getText();
        Assert.assertEquals(resultado, "Cadastrado!");

    }
        @AfterMethod
    public void after(){
       driver.quit();
    }

}
