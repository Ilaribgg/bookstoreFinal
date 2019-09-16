package hh.swd20.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.CategoryRepository;




@Controller
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CategoryRepository crepository;
	
	
	@RequestMapping(value= "/books", method = RequestMethod.GET)
	public String newBook(Model model){
		List<Book> books = (List<Book>) bookRepository.findAll();
		model.addAttribute("books", books);
		return "booklist";
		
	}
	
	@RequestMapping(value = "/newbook", method = RequestMethod.GET)
	public String getNewBookForm(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categorys", crepository.findAll());
		return "bookform";
	}
	
	@RequestMapping(value = "/newbook", method = RequestMethod.POST)
	public String saveCar(@ModelAttribute Book book) {
	bookRepository.save(book);
		return "redirect:/books";
	}
	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:../books";
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id")Long id, Model model) {
		model.addAttribute("book", bookRepository.findById(id));
		model.addAttribute("categorys", crepository.findAll());
		return "editbook";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String editedBook(@ModelAttribute Book book) {
		bookRepository.save(book);
		return "redirect:/books";
	}
}
