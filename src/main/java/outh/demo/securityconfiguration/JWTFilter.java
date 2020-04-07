package outh.demo.securityconfiguration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static outh.demo.securityconfiguration.SecurityConstants.HEADER_STRING;
import static outh.demo.securityconfiguration.SecurityConstants.TOKEN_PREFIX;

public class JWTFilter extends BasicAuthenticationFilter {


    public JWTFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_STRING);

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            String user = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }

}



    /*    @Override

        @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");

        UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationByToken(header);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request,response);

    }

    private UsernamePasswordAuthenticationToken getAuthenticationByToken(String header) {
            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(SECRET.getBytes())
                    .parseClaimsJws(header.replace("Bearer ",""));
           String roleUser = claimsJws.getBody().get("role").toString();
           String nameUser = claimsJws.getBody().get("name").toString();

            Set<SimpleGrantedAuthority> simpleGrantedAuthority = Collections.singleton(new SimpleGrantedAuthority(roleUser));

           UsernamePasswordAuthenticationToken usernamePasswordAuthenticationTokenParsed
                                                = new UsernamePasswordAuthenticationToken(nameUser,null,simpleGrantedAuthority);

           return usernamePasswordAuthenticationTokenParsed;
    }




    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String header = httpServletRequest.getHeader("authorization");
        if(header.startsWith("Bearer ")){
            try {
                String token = header.substring(7);
                Claims claims = Jwts.parser().setSigningKey("damian").parseClaimsJws(token).getBody();
                servletRequest.setAttribute("claims", claims);
            }catch (Exception e){
                throw new ServletException("Wrong key");
            }
        }else{
            throw new ServletException("Wrong Header");
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }*/
