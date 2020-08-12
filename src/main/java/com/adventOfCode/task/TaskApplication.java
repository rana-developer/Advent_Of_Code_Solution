package com.adventOfCode.task;
import com.adventOfCode.task.balanceBot.FirstThreeOutput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.adventOfCode.task.balanceBot.BalanceBot;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
		BalanceBot.testBalanceBot();
		FirstThreeOutput.testFirstThreeOutput();
	}

}
