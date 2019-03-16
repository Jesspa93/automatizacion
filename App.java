package Course.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.*;

public class App {
	public static void main(String[] args) {

		System.out.println("Inicio Proyecto de Automatizacion");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		File archivo = null;
		archivo = new File("archivo.txt");
		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea = "";

			while ((linea = br.readLine()) != null) {
				try {

					System.out.println("Leyendo el contendio del archivo.txt");
					System.out.println(linea);
					String[] bar = linea.split(" ");
					driver.get("https://www.ieee.org/");
					WebElement btnSign = driver.findElement(By.id("mn-signin-link"));
					btnSign.click();
					WebElement txtName = driver.findElement(By.id("username"));
					txtName.sendKeys(bar[0]);
					WebElement txtPasswd = txtPasswd = driver.findElement(By.id("password"));
					txtPasswd.sendKeys(bar[1]);
					WebElement btnEntrar = driver.findElement(By.id("modalWindowRegisterSignInBtn"));
					btnEntrar.click();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}