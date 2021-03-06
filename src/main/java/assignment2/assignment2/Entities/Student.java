package assignment2.assignment2.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import assignment2.assignment2.Entities.Enrolment;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Integer id;

    @Column (name = "name")
    private String name;
    
    @Column (name = "cnp")
    private String cnp;
    
    @Column (name = "gr")
    private Integer gr;
    
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Enrolment> enrolments;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public Integer getGr() {
		return gr;
	}

	public void setGr(Integer gr) {
		this.gr = gr;
	}

	public List<Enrolment> getEnrolments() {
		return enrolments;
	}

	public void setEnrolments(List<Enrolment> enrolments) {
		this.enrolments = enrolments;
	}
    
    
	
}
