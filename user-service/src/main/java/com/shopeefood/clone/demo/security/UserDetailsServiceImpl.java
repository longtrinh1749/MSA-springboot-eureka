package com.shopeefood.clone.demo.security;

import com.shopeefood.clone.demo.entity.AppUser;
import com.shopeefood.clone.demo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<AppUser> users = appUserRepository.findAllByUsername(username);
        for(AppUser appUser: users) {
            List<GrantedAuthority> grantedAuthorities = AuthorityUtils.
                    commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRole());
            return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
        }

        throw new UsernameNotFoundException("Username: " + username + " not found");
    }
}
