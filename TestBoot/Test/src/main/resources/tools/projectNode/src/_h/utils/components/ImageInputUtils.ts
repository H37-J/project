import {EventHandlerUtil, DataUtils, getUniqueIdWithPrefix, getCSS} from '../index'

export interface ImageInputOptions {}

export interface ImageInputQueries {
    componentName: string
    instanseQuery: string
    inputQuery: string
    wrapperQuery: string
    cancelQuery: string
    removeQuery: string
    hiddenQuery: string
}

const defaultImageInputOptions = {}

const defaultImageInputQueires: ImageInputQueries = {
  componentName: 'image-input',
  instanseQuery: '[data-h-image-input]',
  inputQuery: 'input[type="file"]',
  wrapperQuery: '.image-input-wrapper',
  cancelQuery: '[data-h-image-input-action="cancel"]',
  removeQuery: '[data-h-image-input-action="remove"]',
  hiddenQuery: 'input[type="hidden"]',
}