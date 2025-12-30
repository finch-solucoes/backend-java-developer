package com.cmanager.app.authentication.domain;

import com.cmanager.app.application.data.EpisodeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "EPISODES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Episode implements UserDetails {

    @Id
    private String id;
    private String name;
    private int season;
    private Integer number;

    public EpisodeDTO convertToDTO(){
        return new EpisodeDTO(this.id,this.name,this.season,this.number);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}
