import React , {useState , useEffect} from "react";
import {createPortal} from "react-dom";
import {useDispatch , useSelector} from "react-redux";
import CardForm from "./Components/CardItem/CardForm";
import CardAlbumDisplay from "./Components/CardItem/CardAlbumDisplay";
import {addAlbum , deleteAlbum , editAlbum , fetchAlbums} from "./Components/reducer/albumSlice";
import NavbarAlbum from "./Components/NavbarAlbum/NavbarAlbum";
import ModalAddAlbum from "./Components/shared/ModalAddAlbum";
import ListAlbums from "./Components/ListAlbums";


function App() {
    const [albumFormMode , setAlbumFormMode] = useState("")
    const user = useSelector(state => state.auth.user)
    const albums = useSelector(state => state.albums.albums)
    const [modalShow , setModalShow] = useState(false);
    const [selectedAlbum , setSelectedAlbum] = useState(null)
    const dispatch = useDispatch()

    const onAddHandler = async (albumValues) => {
        dispatch(addAlbum(albumValues))
    }
    const onDeleteHandler = async (albumId) => {
        dispatch(deleteAlbum(albumId))
    }
    const onEditHandler = async (albumWithId) => {
        dispatch(editAlbum(albumWithId))
    }

    const setAlbumFormModeAndSelectedAlbum = ({album , mode}) => {
        setSelectedAlbum(album)
        setAlbumFormMode(mode)
    }

    useEffect(() => {
        dispatch(fetchAlbums())
    } , [dispatch])
    return (

        <div className="App">
            <header>
                <NavbarAlbum/>
            </header>
            <main className="container-fluid  d-inline-flex">
                <div className="w-100 bg-dark rounded text-light mt-3 p-3">
                    <nav className="navbar navbar-expand-lg  ">
                        <div className="container-fluid">
                            <a className="navbar-brand text-white" href="#">Albums</a>
                                <form className="d-flex align" role="search">
                                    <label htmlFor="filter:">Filter by:</label>
                                    <input className="form-control me-2" type="search" placeholder="Filter by"
                                           aria-label="Search">
                                    </input>
                                </form>
                            {user && <button className="ms-auto btn btn-success" onClick={() => setModalShow(true)}><i className="bi bi-plus-circle"></i> Add</button>}

                        </div>
                    </nav>

                    <hr/>
                    <div className="row my-3">
                        <div className="col-12">
                            <ListAlbums albums={albums}/>
                        </div>
                    </div>
                    <hr/>
                    <ModalAddAlbum addAlbum={onAddHandler} show={modalShow} onHide={() => setModalShow(false)}/>
                </div>
            </main>

        </div>
    );
}


export default App;
