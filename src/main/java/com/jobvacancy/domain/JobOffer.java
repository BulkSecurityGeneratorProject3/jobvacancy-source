package com.jobvacancy.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A JobOffer.
 */
@Entity
@Table(name = "JOB_OFFER")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class JobOffer implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull        
    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "location")
    private String location;
    
    @Column(name = "description")
    private String description;

    @Column(name = "postulations")
    private Long postulations;
    
    @Column(name = "creation_date")
    @Type(type = "date")
    private Date creationDate;
    
    @Column(name = "expiration_date")
    @Type(type = "date")
    private Date expirationDate;
    
	@Column(name = "active")
    private Boolean active;
    
    @ManyToOne
    private User owner;
    
    public Long getPostulations() {
		return postulations;
	}

	public void setPostulations(Long postulations) {
		this.postulations = postulations;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
 

    public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User user) {
        this.owner = user;
    }

    
    public Date getExpirationDate() {
    	//java.sql.Date date = new java.sql.Date(this.expirationDate.getTime());
    	return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JobOffer jobOffer = (JobOffer) o;

        if ( ! Objects.equals(id, jobOffer.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "JobOffer{" +
                "id=" + id +
                ", title='" + title + "'" +
                ", location='" + location + "'" +
                ", description='" + description + "'" +", postilations='"+postulations + "'" + 
                '}';
    }
}
