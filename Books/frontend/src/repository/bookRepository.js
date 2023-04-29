import axios from '../custom-axios/axios';


const BookService = {
    fetchBooks: () => {
        return axios.get("/books");
    },
    
    fetchCategories: () => {
        return axios.get("/categories");
    },

    fetchAuthors: () => {
        return axios.get("/authors");
    },

    deleteBook: (id) => {
        return axios.delete(`/books/${id}/delete`);
    },

    addBook: (name, category, author, availableCopies) => {
        return axios.post("/books/add", {
            "name":name,
            "category":category,
            "author":author,
            "availableCopies":availableCopies
        });
    },

    editBook: (id, name, category, author, availableCopies) => {
        return axios.put(`/books/${id}/edit`, {
            "name":name,
            "category":category,
            "author":author,
            "availableCopies":availableCopies
        })
    },

    getBook: (id) => {
        return axios.get(`/books/${id}`);
    },

    markAsTaken: (id) => {
        return axios.put(`/books/${id}/rent`);
    }
};

export default BookService;

