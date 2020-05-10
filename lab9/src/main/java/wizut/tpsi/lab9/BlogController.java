
package wizut.tpsi.lab9;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    
    private final BlogRepository blogrepo;
    
    @Autowired        
    public BlogController(BlogRepository blogrepo){
        this.blogrepo = blogrepo;
    }
            
    @RequestMapping("/")
    public String home(Model model) throws SQLException{
        List<BlogPost> blogposts = blogrepo.getAllPosts();
        
        model.addAttribute("post", blogposts);
        return "index.html";

    }
    
    @PostMapping("/newpost") 
    public String newPost(BlogPost post) throws SQLException{
        blogrepo.createPost(post);
        return "redirect:/";
    }
    
    @PostMapping("/deletepost") 
    public String delPost(@RequestParam Long id) throws SQLException{
       
        blogrepo.delPost(id);
        return "redirect:/";
    }
    
    
    
    
}
    

