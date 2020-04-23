package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.Usuario;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Path do arquivo de log:");
		String path = sc.nextLine();
		Set<Usuario> usuarios = new HashSet<>();
		try (BufferedReader bf = new BufferedReader(new FileReader(path))){
			String linha = bf.readLine();
			while(linha != null) {
				String[] data = linha.split(" ");
				Usuario user = new Usuario(data[0],Date.from(Instant.parse(data[1])));
				usuarios.add(user);
				linha = bf.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		for(Usuario user : usuarios) {
			System.out.println(user.toString());
		}
		System.out.println("Total de usuários-> "+usuarios.size());
		sc.close();
	}

}
