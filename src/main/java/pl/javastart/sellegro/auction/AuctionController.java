package pl.javastart.sellegro.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Controller
public class AuctionController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;



    @GetMapping("/auctions")
    public String auctions(Model model ) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Auction> query;
        query = entityManager.createQuery("SELECT a from Auction a ", Auction.class);


        List<Auction> auctions = query.getResultList();
        model.addAttribute("auctions", auctions);
        entityManager.close();
        return "auctions";
    }
}