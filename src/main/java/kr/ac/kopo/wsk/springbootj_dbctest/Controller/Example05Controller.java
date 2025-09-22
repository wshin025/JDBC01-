package kr.ac.kopo.wsk.springbootj_dbctest.Controller;


import kr.ac.kopo.wsk.springbootj_dbctest.domain.Detail;
import kr.ac.kopo.wsk.springbootj_dbctest.domain.Product;
import kr.ac.kopo.wsk.springbootj_dbctest.repository.DetailReopsitory;
import kr.ac.kopo.wsk.springbootj_dbctest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/exam05")
public class Example05Controller {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DetailReopsitory detailReopsitory;

    @GetMapping
    public String requestInsert(Model model) {
        Product product = new Product();
        product.setName("Iphone17");
        product.setPrice(1200000);

        Detail detail = new Detail();
        detail.setDescription("Iphone17 2025신형");
        detail.setWeight(200f);
        detail.setWidth(75f);
        detail.setHeight(150f);

        product.setDetail(detail);

        productRepository.save(product);

        List<Product> productList = productRepository.findAll();
        List<Detail> detailList = detailReopsitory.findAll();

        model.addAttribute("productList", productList);
        model.addAttribute("detailList", detailList);

        return "viewPage05";
    }
}
