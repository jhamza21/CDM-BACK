package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.entities.Referee;
import com.example.entities.Team;
import com.example.repository.RefereeRepository;
import com.example.repository.TeamRepository;

@EnableJpaRepositories(basePackages = "com.example")
@SpringBootApplication
public class Coupedumonde20221Application implements CommandLineRunner {

	@Autowired
	private TeamRepository tr;
	@Autowired
	private RefereeRepository rr;

	public static void main(String[] args) {
		SpringApplication.run(Coupedumonde20221Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Team t = new Team("TUNISIA");
		tr.save(t);
		t = new Team("ALGERIA");
		tr.save(t);
		t = new Team("JAPAN");
		tr.save(t);
		t = new Team("SPAIN");
		tr.save(t);
		t = new Team("ITALY");
		tr.save(t);
		t = new Team("GERMANY");
		tr.save(t);
		t = new Team("EGYPT");
		tr.save(t);
		t = new Team("BELGIUM");
		tr.save(t);
		t = new Team("ARGENTINA");
		tr.save(t);
		t = new Team("CHAD");
		tr.save(t);
		t = new Team("COLOMBIA");
		tr.save(t);
		t = new Team("CHILE");
		tr.save(t);
		t = new Team("CHINA");
		tr.save(t);
		t = new Team("BRAZIL");
		tr.save(t);
		t = new Team("GHANA");
		tr.save(t);
		t = new Team("GABON");
		tr.save(t);
		t = new Team("CROATIA");
		tr.save(t);
		t = new Team("FRANCE");
		tr.save(t);
		t = new Team("GREECE");
		tr.save(t);
		t = new Team("ICELAND");
		tr.save(t);
		t = new Team("IRELAND");
		tr.save(t);
		t = new Team("IVORY COAST");
		tr.save(t);
		t = new Team("KOREA");
		tr.save(t);
		t = new Team("MALI");
		tr.save(t);
		t = new Team("MEXICO");
		tr.save(t);
		t = new Team("QATAR");
		tr.save(t);
		t = new Team("PORTUGAL");
		tr.save(t);
		t = new Team("RUSSIA");
		tr.save(t);
		t = new Team("SWEDEN");
		tr.save(t);
		t = new Team("ROMANIA");
		tr.save(t);
		t = new Team("LUXEMBOURG");
		tr.save(t);

		Referee r = new Referee(0, "RAMI", "N", false, 5);
		rr.save(r);
		r = new Referee(0, "ahmed", "N", false, 5);
		rr.save(r);
		r = new Referee(0, "salem", "N", false, 5);
		rr.save(r);
		r = new Referee(0, "omar", "N", false, 5);
		rr.save(r);
		r = new Referee(0, "aymen", "N", false, 5);
		rr.save(r);
		r = new Referee(0, "kasama", "N", false, 5);
		rr.save(r);
		r = new Referee(0, "omar", "N", false, 5);
		rr.save(r);
		r = new Referee(0, "khalil", "N", false, 5);
		rr.save(r);
		r = new Referee(0, "bechir", "N", false, 5);
		rr.save(r);
		r = new Referee(0, "RAMzI", "N", false, 5);
		rr.save(r);
}
}
