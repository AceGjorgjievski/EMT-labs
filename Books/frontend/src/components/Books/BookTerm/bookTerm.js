import React from 'react';
import {Link} from 'react-router-dom';


const bookTerm = (props) => {
    return (
        <tr>
            <td scope={"col"}>{props.term.name}</td>
            <td scope={"col"}>{props.term.category}</td>
            <td scope={"col"}>{props.term.author.name}</td>
            <td scope={"col"}>{props.term.availableCopies}</td>
            <td scope={"col"} className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger"}
                onClick={() => props.onDelete(props.term.id)}>
                    Delete</a>
                    <Link className={"btn btn-info ml-2"}
                      onClick={() => props.onEdit(props.term.id)}
                      to={`/books/${props.term.id}/edit`}>Edit</Link>
                    <Link className={"btn btn-light ml-2"}
                        onClick={() => props.onMarkAsTaken(props.term.id)}
                    >Mark As Taken</Link>
            </td>
        </tr>
    );
}


export default bookTerm;


