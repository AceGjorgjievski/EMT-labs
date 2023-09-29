import './App.css';
import React, {Component} from 'react';
import {BrowserRouter as Router, Redirect, Routes, Navigate, Route, Link} from 'react-router-dom';
import BookService from '../../repository/bookRepository';
import Books from '../Books/BookList/books';
import BookAdd from '../Books/BookAdd/bookAdd';
import BookEdit from '../Books/BookEdit/bookEdit';
import Categories from '../Categories/categories';
import Authors from '../Authors/authors';
import Header from '../Header/header';


class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories: [],
            authors: [],
            selectedBook: {}
        }
    }

    render() {
        // console.log("inside render ...")
        return (
            // <div>
            //   <Books books={this.state.books}/>
            // </div>
            <Router>
                <main>
                    <Header/>
                    <div className="container">
                        {/* <Route path={["/books","/"]} exact render={() => <Books books={this.state.books} onDelete={this.deleteBook}/>}/>
              <Route path={"/categories"} exact render={() => <Categories categories={this.state.categories}/>}/> */}
                        <Routes>
                            <Route path='/books/:id/edit' element={
                                <BookEdit categories={this.state.categories}
                                          authors={this.state.authors}
                                          onEdit={this.editBook}
                                          book={this.state.selectedBook}/>}/>
                            <Route path='/books/add' element={
                                <BookAdd categories={this.state.categories}
                                         authors={this.state.authors}
                                         onAddBook={this.addBook}/>}/>
                            <Route path='/books' element={
                                <Books books={this.state.books}
                                       onDelete={this.deleteBook}
                                       onEdit={this.getBook}
                                       onMarkAsTaken={this.markAsTaken}/>}/>
                            <Route path='/categories' element={
                                <Categories categories={this.state.categories}/>}/>
                            <Route path='/authors' element={
                                <Authors authors={this.state.authors}/>}/>
                            <Route path="/" element={
                                <Books books={this.state.books}
                                       onDelete={this.deleteBook}
                                       onEdit={this.getBook}
                                       onMarkAsTaken={this.markAsTaken}/>}/>
                        </Routes>

                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        // console.log("did mounted invoked");
        this.loadBooks();
        this.loadCategories();
        this.loadAuthors();
    }

    loadBooks = () => {
        BookService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            })
    }

    deleteBook = (id) => {
        BookService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            })
    }

    addBook = (name, category, author, availableCopies) => {
        BookService.addBook(name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            })
            .catch((error) => {
                console.log('error in addBook: ' + error);
            });
    }

    getBook = (id) => {
        BookService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            })
    }

    editBook = (id, name, category, author, availableCopies) => {
        console.log("inseide editBook ", id, name, category, author, availableCopies);
        BookService.editBook(id, name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            })
    }

    markAsTaken = (id) => {
        BookService.markAsTaken(id)
            .then(() => {
                this.loadBooks();
            })
    }

    loadCategories = () => {
        BookService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            })
    }

    loadAuthors = () => {
        BookService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            })
    }

}


export default App;
