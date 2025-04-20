package com.telusko.SpringDataJpaLOB;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.telusko.SpringDataJpaLOB.entity.MarriageSeeker;
import com.telusko.SpringDataJpaLOB.service.MarriageSeekeriImp;

@SpringBootApplication
public class SpringDataJpaLobApplication 
{

	public static void main(String[] args) throws IOException 
	{
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataJpaLobApplication.class, args);
		
		MarriageSeekeriImp service = context.getBean(MarriageSeekeriImp.class);
		
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter the name");
//		String name=sc.next();	
//		System.out.println("Enter the city");
//		String city=sc.next();
//		System.out.println("Kindly enter the image path : ");
//		String imagePath=sc.next();
//		System.out.println("Kindly enter the biodata file path : ");
//		String filePath=sc.next();
//		
//		InputStream input=new FileInputStream(imagePath);
//		byte image[]=new byte[input.available()];
//		
//		input.read(image);
//		
//		File file=new File(filePath);
//		Reader reader=new FileReader(file);
//		char charFile[]=new char[(int) file.length()];
//		reader.read(charFile);
//		
//		
//		
//		MarriageSeeker seeker=new MarriageSeeker("Rohan", "Bengaluru", image, charFile);
//		
//		System.out.println(service.registerMarriageSeeker(seeker));
		
		Optional<MarriageSeeker> optional = service.searchById(1L);
		if(optional.isPresent())
		{
			MarriageSeeker seek = optional.get();
			System.out.println(seek.getId()+ " "+ seek.getName() + " "+ seek.getCity());
			OutputStream os=new FileOutputStream("image.jpeg");
			os.write(seek.getPhoto());
			os.flush();
			
			Writer write=new FileWriter("bioData.txt");
			write.write(seek.getBioData());
			write.flush();
		}
		else
		{
			System.out.println("Some prob, unable to get the data");
		}
		context.close();
	
	
	
	}

}
