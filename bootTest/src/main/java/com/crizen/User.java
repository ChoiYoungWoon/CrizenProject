package com.crizen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")//생략가능하며 table 생략시 같은이름을 찾아 매핑함
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//고유값 자동생성
	private long  seq;
	
	@Column(name="ID_USER" ,length=50 ,nullable=false)
			//컬럼명 매핑   , 길이값, 고유키설정, 널값설정 등 속성 설정 가능
	private String idUser;
	

	@Override
	public String toString() {
		return "User [seq=" + seq + ", idUser=" + idUser + "]";
	}

	public User(){}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	


		
	
}
