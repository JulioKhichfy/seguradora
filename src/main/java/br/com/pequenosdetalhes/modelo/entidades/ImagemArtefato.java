package br.com.pequenosdetalhes.modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ImagemArtefato {
	
	private long id;
    private String fileName;
    private byte[] data;
    
      
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
    
    public String getFileName() {
        return fileName;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
 
    public byte[] getData() {
        return data;
    }
 
    public void setData(byte[] data) {
        this.data = data;
    }


}
