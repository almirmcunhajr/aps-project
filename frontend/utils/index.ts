export const translateType = ({type}: {type: string}) => {
  let response = '';
  switch(type) {
    case 'movie':
      response = 'Filme';
      break;
    case 'show':
      response = 'Série';
      break;
    default:
      response = type;
      break;
  }

  return response;
}

export const translateLanguage = ({language}: {language: string}) => {
  let response = '';
  switch(language) {
    case 'en':
      response = 'Inglês';
      break;
    case 'pt-br':
      response = 'Português';
      break;
    case 'pt':
      response = 'Português';
      break;
    case 'fr':
      response = 'Francês';
      break;
    case 'hi':
      response = 'Indiano';
      break;
    case 'de':
      response = 'Alemão';
      break;
    case 'tr':
      response = 'Turco';
      break;
    case 'tl':
      response = 'Filipino';
      break;
    case 'af':
      response = 'Africâner';
      break;
    case 'pl':
      response = 'Polonês';
      break;
    case 'it':
      response = 'Italiano';
      break;
    case 'ja':
      response = 'Japonês';
      break;
    case 'es':
      response = 'Espanhol';
      break;
    case 'hr':
      response = 'Croata';
      break;
    case 'he':
      response = 'Hebraico';
      break;
    case 'hu':
      response = 'Húngaro';
      break;
    case 'da':
      response = 'Dinamarquês';
      break;
    case 'ru':
      response = 'Russo';
      break;
    case 'zh':
      response = 'Chinês';
      break;
    default:
      response = language;
      break;
  }

  return response;
}