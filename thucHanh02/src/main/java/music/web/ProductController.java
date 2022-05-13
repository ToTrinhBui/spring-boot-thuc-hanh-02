package music.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;

import lombok.extern.slf4j.Slf4j;
import music.business.Product;
import music.data.ProductRepository;

@Slf4j
@Controller
@RequestMapping("/products")
public class ProductController {
	private final ProductRepository productRepo;

	@Autowired
	public ProductController(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}

	@ModelAttribute
	public void addProductToModel(Model model) {
		List<Product> products = (List<Product>) productRepo.findAll();
		model.addAttribute("products", products);
	}

	@GetMapping
	public String showProduct() {
		return "products";
	}

	@GetMapping("/add")
	public String addProduct(Model model) {
		model.addAttribute("product", new Product(null, null, 0));
		return "addProduct";
	}

	@GetMapping("/edit")
	public String editProduct(@RequestParam("code") String code, Model model) {
		Optional<Product> productX = productRepo.findById(code);
		productX.ifPresent(product -> model.addAttribute("product", product));
		return "editProduct";
	}

	@GetMapping("/confirmDelete")
	public String confirmDeleteProduct(@RequestParam("code") String code, Model model) {
		Optional<Product> productX = productRepo.findById(code);
		productX.ifPresent(product -> model.addAttribute("product", product));
		return "deleteProduct";
	}

	@PostMapping("/delete")
	public String deleteProduct(Product product, Model model) {
		productRepo.delete(product);
		model.addAttribute(product);
		return "redirect:/products";
	}

	@PostMapping("/save")
	public String saveProduct(@Valid Product product, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "addProduct";
		else {
			productRepo.save(product);
			model.addAttribute(product);
			log.info("Product saved: " + product);
			return "addProductSuccess";
		}
	}

	@PostMapping("/edit")
	public String editProduct(Product product, Model model) {
		productRepo.save(product);
		model.addAttribute(product);
		log.info("Product saved: " + product);
		return "redirect:/products";
	}
}