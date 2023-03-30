import classes from './ModalComponent.module.css'

const ModalComponent = (props) => {

  const closeModalHandler = (event) => {
    if (event.target === event.currentTarget) {
      props.closeModal()
    }
  }

  return (
    <div className={classes.modal} onClick={closeModalHandler}>
      <div className={classes['modal-content']}>
        {props.children}
      </div>
    </div>
  )
}

export default ModalComponent